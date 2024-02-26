package com.dmdev.javacore.collections.chats.task1.util;

import com.dmdev.javacore.collections.chats.task1.entity.Chat;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class ChatUtils {

    private ChatUtils() {

    }

    public static List<Chat> removeChatsWithUsersNumberLessThen(List<Chat> chats, int usersThreshold) {
        if (usersThreshold < 0) {
            throw new IllegalArgumentException("Error: chat users number below zero");
        }

        Iterator<Chat> chatIterator = chats.iterator();
        while (chatIterator.hasNext()) {
            if (chatIterator.next().getNumberOfUsers() < usersThreshold) {
                chatIterator.remove();
            }
        }

        return chats;
    }

    public static void sortChatsByDescendingUsersThenByName(List<Chat> chats) {
        Comparator<Chat> chatComparator = new Comparator<Chat>() {
            @Override
            public int compare(Chat chat, Chat chat1) {
                return (chat.getNumberOfUsers() == chat1.getNumberOfUsers())
                        ? chat.getName().compareTo(chat1.getName())
                        : Integer.compare(chat1.getNumberOfUsers(), chat.getNumberOfUsers());
            }
        };

        chats.sort(chatComparator);
    }
}
