package command.definitions

interface ICommand {
    val commandName: String
    fun execute(args: ArrayList<String>?)
}