package io.github.jroy.happybot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.jroy.happybot.util.C;
import io.github.jroy.happybot.util.Roles;
import net.dv8tion.jda.core.entities.Member;

public class FansCommand extends Command {

    public FansCommand() {
        this.name = "fixfans";
        this.help = "Fixes broken users with no Fans Role";
        this.guildOnly = true;
        this.category = new Category("Staff Tools");
    }

    @Override
    protected void execute(CommandEvent e) {
        if (C.hasRole(e.getMember(), Roles.SUPER_ADMIN)) {
            e.reply("Loading...");
            int affected = 0;
            for (Member curM : C.getGuild().getMembers()) {
                if (!C.hasRole(curM, Roles.FANS) && !curM.getUser().isBot()) {
                    C.giveRole(curM, Roles.FANS);
                    affected++;
                }
            }
            e.replySuccess("All Done!\n" + String.valueOf(affected) + " Users Affected!");
        } else {
            e.replyError(C.permMsg(Roles.SUPER_ADMIN));
        }
    }
}
