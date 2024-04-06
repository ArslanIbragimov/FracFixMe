import subprocess
import shutil
import os
from xml.etree import ElementTree

with open("./pom.xml") as f:
    tree = ElementTree.parse(f)
    version = tree.getroot().find("{http://maven.apache.org/POM/4.0.0}version").text
mvn_path = shutil.which("mvn")
subprocess.check_call([mvn_path, "package"])

os.chdir(os.path.join("target"))

shutil.copy(f"./FracFixMe-{version}.jar", os.path.join("..", "site_docker", f"FracFixMe-{version}.jar"))

subprocess.check_call(["docker-compose", "build"])
