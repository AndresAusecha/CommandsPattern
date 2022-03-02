package command.impl
import java.io.File
import java.nio.file.Paths

import command.definitions.ICommand

class FileCommand: ICommand {
    override fun execute(args: Array<String>?) {
        if(args!!.isEmpty()) {
            throw Exception("Invalid parameters")
        }

        if(args[1].lowercase() == "-n") {
            val file = File(args[2])
            file.createNewFile()
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