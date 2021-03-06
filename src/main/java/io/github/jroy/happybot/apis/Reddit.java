package io.github.jroy.happybot.apis;

import io.github.jroy.happybot.util.BotConfig;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;

public class Reddit extends APIBase {

    private final String username;
    private final String password;
    private final String clientId;
    private final String clientSecret;

    private RedditClient redditClient;

    public Reddit(BotConfig botConfig) {
        super("Reddit");
        this.username = botConfig.getRedditUsername();
        this.password = botConfig.getRedditPassword();
        this.clientId = botConfig.getRedditClientId();
        this.clientSecret = botConfig.getRedditClientSecret();
    }

    @Override
    public void loadApi() {
        NetworkAdapter adapter = new OkHttpNetworkAdapter(new UserAgent("happybot", "io.github.jroy", "v0.1", "wheezygold7931"));
        Credentials credentials = Credentials.script(username, password, clientId, clientSecret);
        redditClient = OAuthHelper.automatic(adapter, credentials);
    }

    public RedditClient getRedditClient() {
        return redditClient;
    }
}
