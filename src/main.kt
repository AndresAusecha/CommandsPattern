import command.definitions.ICommand
import command.impl.DirCommand
import command.impl.FileCommand

var line: String = ""
lateinit var command: ICommand
lateinit var lineParts: ArrayList<String>

fun main() {
    CommandManager.registerCommands("DirCommand", DirCommand("DirCommand"))
    CommandManager.registerCommands("FileCommand", FileCommand("FileCommand"))

    while (true) {
        println("Enter your command name")
        line = readln()
        if (line == "exit") {
            break
        }
        lineParts = line.split(" ") as ArrayList<String>
        command = CommandManager.getCommand(lineParts[0])
            ?: throw Exception("Command not found")
        print("This is the list of parts \n")
        lineParts.forEach {
            print("$it \n")
        }
        command.execute(lineParts)
    }
}