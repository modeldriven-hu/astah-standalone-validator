import os
import sys
from lxml import etree
from git import Repo

def parse_xml(file_path):
    """Parses an XML file and returns a dictionary of elements with xml:id as key."""
    tree = etree.parse(file_path)
    root = tree.getroot()

    elements = {}
    for elem in root.xpath("//*[@xmi:id]", namespaces={"xmi": "http://www.omg.org/spec/XMI/20131001"}):
        xml_id = elem.attrib["{http://www.omg.org/spec/XMI/20131001}id"]
        elements[xml_id] = etree.tostring(elem, encoding="unicode", pretty_print=True)

    return elements

def get_branch_creation_commit(repo, branch_name):
    """Gets the commit where the branch was created."""
    branch = repo.heads[branch_name]
    merge_base = repo.merge_base(branch, repo.heads.master)
    return merge_base[0] if merge_base else None


def compare_xml_versions(repo_path, branch_name, file_path):
    """Compares two versions of an XML file based on the xml:id attribute."""
    repo = Repo(repo_path)
    if repo.is_dirty():
        print("The repository has uncommitted changes. Please commit or stash them before running the script.")
        sys.exit(1)

    # Get branch creation commit
    creation_commit = get_branch_creation_commit(repo, branch_name)
    if not creation_commit:
        print(f"Could not determine the creation commit for branch {branch_name}.")
        sys.exit(1)

    # Paths for temporary files
    temp_dir = ".temp_git_files"
    os.makedirs(temp_dir, exist_ok=True)

    original_file = os.path.join(temp_dir, "original.xml")
    current_file = os.path.join(temp_dir, "current.xml")

    # Checkout original version of the file
    with open(original_file, "w") as f:
        f.write(creation_commit.tree[file_path].data_stream.read().decode("utf-8"))

    # Checkout current version of the file
    with open(current_file, "w") as f:
        f.write(repo.head.commit.tree[file_path].data_stream.read().decode("utf-8"))

    # Parse XML files
    original_elements = parse_xml(original_file)
    current_elements = parse_xml(current_file)

    # Compare elements
    added_or_modified = {
        xml_id: current_elements[xml_id]
        for xml_id in current_elements
        if xml_id not in original_elements or original_elements[xml_id] != current_elements[xml_id]
    }

    # Cleanup temporary files
    os.remove(original_file)
    os.remove(current_file)
    os.rmdir(temp_dir)

    return added_or_modified


if __name__ == "__main__":
    repo_path = 'C:/Home/Temp/model'
    branch_name = 'test'
    file_path = 'sysml-model.auml'

    try:
        added_or_modified_elements = compare_xml_versions(repo_path, branch_name, file_path)

        if added_or_modified_elements:
            print("Added or modified elements:")
            for xml_id, _ in added_or_modified_elements.items():
                print(f"xml:id = {xml_id}\n")
        else:
            print("No elements were added or modified.")

    except Exception as e:
        print(f"An error occurred: {e}")
