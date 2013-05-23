MyMOTD is a (very) lightweight plugin to allow the server list MOTD to be changed in-game.

# Usage

Set the MOTD to "Hello world!":

    /motd Hello World!

Display the current MOTD:

    /motd

Colour codes can also be used:

    /motd &aHello &cWorld&d!

# Commands

* `/motd` - Display the MOTD
* `/motd <text>` - Set the MOTD (colour codes can be used)

# Permissions

* `mymotd.get` - Gives access to display the MOTD (/motd).
* `mymotd.set` - Gives access to change the MOTD (/motd ...).
* `mymotd.*` - Gives access to all MyMOTD functionality.

# Configuration

No configuration file is needed; however the current MOTD is stored in motd.txt upon the plugin being disabled and is loaded upon being enabled.

# Development Builds

Development builds can be found on the [build server][build-server].

**Use these at your own risk. They are not guaranteed to have been fully tested.**

[build-server]: http://bukkit.kierdavis.com/MyMOTD/
