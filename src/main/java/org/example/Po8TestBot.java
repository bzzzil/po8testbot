package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

public class Po8TestBot extends TelegramLongPollingBot {
    public Po8TestBot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            String username = update.getMessage().getChat().getUserName();
            long chatId = update.getMessage().getChatId();

            switch (text) {
                case "/start":
                    sendMessage(chatId, "окей, окей. запускаюсь!");
                    break;
                case "/hello":
                    sendMessage(chatId, "И тебе привет!");
                    break;
                default:
                    System.out.println("@" +  username + ": " + text);
            }
        }
    }

    private void sendMessage(long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "po8testbot";
    }
}
