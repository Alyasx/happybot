package io.github.jroy.happybot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import io.github.jroy.happybot.util.C;

public class VideoCommand extends Command {

    public VideoCommand() {
        this.name = "randomvid";
        this.help = "Picks a random happyheart video and gives it to you!";
        this.guildOnly = false;
        this.category = new Category("Fun");
    }

    @Override
    protected void execute(CommandEvent e) {
        String randomVideo = C.urlExpand("https://mityurl.com/y/MEzr/r");
        if (randomVideo != null) {
            e.replySuccess("Here you go: " + randomVideo);
        } else {
            e.replyError("Sorry :cry:... The YouTube API is having a temporary hiccup.");
        }
    }
}
