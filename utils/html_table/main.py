import json

# Load the JSON data from the file
with open("data.json", "r") as file:
    data = json.load(file)

# Extract the results array
results = data.get("results", [])

# HTML template
html_template = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Validation Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <h1>Validation Results</h1>
    <table>
        <thead>
            <tr>
                <th>Rule Name</th>
                <th>Rule Message</th>
                <th>Severity</th>
                <th>Element Name</th>
                <th>Element Type</th>
                <th>Element ID</th>
            </tr>
        </thead>
        <tbody>
"""

# Add table rows from the JSON data
for result in results:
    html_template += f"""
            <tr>
                <td>{result.get("rule-name", "N/A")}</td>
                <td>{result.get("rule-message", "N/A")}</td>
                <td>{result.get("rule-severity", "N/A")}</td>
                <td>{result.get("element-name", "N/A")}</td>
                <td>{result.get("element-type", "N/A")}</td>
                <td>{result.get("element-id", "N/A")}</td>
            </tr>
    """

# Close the HTML tags
html_template += """
        </tbody>
    </table>
</body>
</html>
"""

# Write the HTML content to a file
with open("validation_results.html", "w") as file:
    file.write(html_template)

print("HTML table has been created. Open 'validation_results.html' in a browser to view it.")
