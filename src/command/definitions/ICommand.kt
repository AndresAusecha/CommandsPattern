package command.definitions

interface ICommand {
    fun execute(args: Array<String>?)
}