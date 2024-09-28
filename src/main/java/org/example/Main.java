package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi tbi = new TelegramBotsApi(DefaultBotSession.class);
            Po8TestBot bot = new Po8TestBot("7838887310:AAEE-qBHC11ciXYAvP9pVrFoLKrvTAfNsB8");
            tbi.registerBot(bot);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
