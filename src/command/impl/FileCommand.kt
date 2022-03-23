package command.impl
import java.io.File
import java.nio.file.Paths

import command.definitions.ICommand

class FileCommand(override val commandName: String) : ICommand {
    override fun execute(args: ArrayList<String>?) {
        if(args!!.isEmpty()) {
            throw Exception("Invalid parameters")
        }

        if(args[1].lowercase() == "-n") {
            val file = File(args[2])
            file.createNewFile()
            print("file with name: ${args[2]} was created")
        } else if (args[1].lowercase() == "-d") {
            val filePath = Paths.get(args[2])

            if(filePath.toFile().delete()){
                println("Deleted ${filePath.fileName}")
            } else {
                println("Could not delete ${filePath.fileName}")
            }
        } else {
            println("Non supported operation")
        }
    }
}