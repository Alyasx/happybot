package io.github.jroy.happybot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.jroy.happybot.util.C;
import io.github.jroy.happybot.util.Roles;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.PermissionOverride;
import net.dv8tion.jda.core.managers.PermOverrideManager;

public class UnlockCommand extends Command {
    public UnlockCommand() {
        this.name = "unlock";
        this.help = "Unlocks the current channel!";
        this.guildOnly = true;
        this.category = new Category("Staff Tools");
    }

    @Override
    protected void execute(CommandEvent e) {
        if (C.hasRole(e.getMember(), Roles.SUPER_ADMIN)) {
            try {
                PermissionOverride permissionOverride = e.getTextChannel().getPermissionOverride(Roles.EVERYONE.getRole());
                PermOverrideManager manager = permissionOverride.getManager();
                manager.grant(Permission.MESSAGE_WRITE).queue();
                e.replySuccess(":unlock: Channel has been unlocked!");
            } catch (NullPointerException npe) {
                e.replyError("An error occurred while un-locking the channel! Please make sure this channel is setup correctly.");
            }
        } else {
            e.replyError(C.permMsg(Roles.SUPER_ADMIN));
        }
    }
}
