package command.impl

import command.definitions.ICommand

class WriteInConsole(override val commandName: String) : ICommand {
    override fun execute(args: ArrayList<String>?) {
        TODO("Not yet implemented")
    }
}