import command.definitions.ICommand

class CommandManager {
    companion object {
        private val commands:HashMap<String, ICommand> = HashMap()
        fun registerCommands(name: String, command: ICommand) {
            commands[name] = command
        }
        fun getCommand(commandName:String): ICommand? {
            return commands[commandName]
        }
    }
}