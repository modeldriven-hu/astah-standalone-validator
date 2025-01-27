package hu.modeldriven.astah.axmz.common;

import hu.modeldriven.astah.axmz.AstahProjectImportFailedException;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class FileInZip {

    private final File zipFile;
    private final String fileName;
    private final File tempFileRoot;

    public FileInZip(File zipFile, String fileName, File tempFileRoot) {
        this.zipFile = zipFile;
        this.fileName = fileName;
        this.tempFileRoot = tempFileRoot;
    }

    public File file() {

        Map<String, String> env = new HashMap<>();
        env.put("create", "false");

        try (FileSystem fileSystem = FileSystems.newFileSystem(zipFile.toPath(), env)) {

            var visitor = new FileInZipVisitor();

            for (Path rootDirectory : fileSystem.getRootDirectories()) {
                Files.walkFileTree(rootDirectory, visitor);
            }

            return visitor.tempFile();

        } catch (IOException e) {
            throw new AstahProjectImportFailedException(e);
        }
    }

    class FileInZipVisitor extends SimpleFileVisitor<Path> {

        private File tempFile;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.getFileName().toString().equals(fileName)) {

                try {
                    String prefix = fileName.substring(0, fileName.lastIndexOf('.'));
                    String suffix = fileName.substring(fileName.lastIndexOf('.'));
                    tempFile = File.createTempFile(prefix, suffix, tempFileRoot);
                    Files.copy(file, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.TERMINATE;

                } catch (Exception e) {
                    throw new AstahProjectImportFailedException(e);
                }

            }

            return FileVisitResult.CONTINUE;
        }

        File tempFile() {
            return tempFile;
        }
    }
}
