import command.definitions.ICommand
import command.impl.DirCommand
import command.impl.FileCommand
import command.impl.WriteInConsole

var line: String = ""
lateinit var command: ICommand
lateinit var lineParts: ArrayList<String>

fun main(args: Array<String>) {
    CommandManager.registerCommands("DirCommand", DirCommand("DirCommand"))
    CommandManager.registerCommands("FileCommand", FileCommand("FileCommand"))
    CommandManager.registerCommands("WriteInConsole", WriteInConsole("WriteInConsole"))


    while (line != "exit") {
        println("Enter your command name")
        line = readln()
        lineParts = line.split(" ") as ArrayList<String>
        command = CommandManager.getCommand(lineParts[0])
            ?: throw Exception("Command not found")
        print("This is the list of parts")
        lineParts.forEach {
            print(it)
        }
        command.execute(lineParts)
    }
}