import json
from rich.console import Console
from rich.table import Table
from rich import box

# Load the JSON data from the file
with open("output.json", "r") as file:
    data = json.load(file)

# Extract the results array
results = data.get("results", [])

# Initialize the console
console = Console()

# Create a table with columns
table = Table(
    title="Validation Results",
    box=box.ROUNDED,
    title_justify="center",
    title_style="bold green",
)

# Add columns to the table
table.add_column("Element ID", style="white",  no_wrap=True, justify="left")
table.add_column("Element Name", style="magenta")
table.add_column("Element Type", style="green")
table.add_column("Rule Name", style="bold yellow", no_wrap=True)
table.add_column("Rule Message", style="cyan")
table.add_column("Severity", style="bold red", no_wrap=True)

# Add rows to the table
for result in results:
    table.add_row(
        result.get("element-id", "N/A"),
        result.get("element-name", "N/A"),
        result.get("element-type", "N/A"),
        result.get("rule-name", "N/A"),
        result.get("rule-message", "N/A"),
        result.get("rule-severity", "N/A")
    )

# Print the table to the console
console.print(table)
