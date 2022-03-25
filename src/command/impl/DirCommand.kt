package command.impl

import command.definitions.ICommand
import java.nio.file.Files
import java.nio.file.Paths

class DirCommand(override val commandName: String) : ICommand {
    override fun execute(args: ArrayList<String>?) {
        if(args!!.isEmpty()) {
            throw Exception("Invalid parameters")
        }

        if(args[1].lowercase() == "-n") {
            val folderPath = Paths.get(args[2])
            Files.createDirectory(folderPath)
            print("")
        } else if (args[1].lowercase() == "-d") {
            val filePath = Paths.get(args[2])
            try {
                Files.delete(filePath)
                println("Deleted ${filePath.fileName}")
            } catch (ex: Exception) {
                println("Could not delete ${filePath.fileName}")
            }
        } else {
            println("Non supported operation")
        }
    }
}