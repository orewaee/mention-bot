# mention-bot

## About

A bot for Telegram that adds some utility to mentions in chats. With it, you can flexibly customize mentions and permissions to use them.

![](pictures/preview.png)


## Installation

At the moment only direct launch of `jar` file is supported.

To do this, you must first clone the project and go to the created directory:

```bash
git clone https://github.com/orewaee/mention-bot.git
cd mention-bot
```

Next, use `./gradlew shadowJar` to get the jar file.

When your `jar` file is ready, run it for the first time using the command `java -jar mention-bot-x.x.x.x.jar`. You will most likely get an error related to the creation of the default config. The point is that the values specified in it are not suitable for the bot to work properly. Provide the `TELEGRAM_BOT_TOKEN` environment variable and customize `config.yaml` as you need it and run the bot again. The next launch should be successful.
