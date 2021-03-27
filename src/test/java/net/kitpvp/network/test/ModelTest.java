package net.kitpvp.network.test;

import net.kitpvp.network.chat.ChatFormats;
import org.junit.Assert;
import org.junit.Test;

public class ModelTest {

    @Test
    public void testChatFormats() {
        Assert.assertTrue("Global Prefix length must be > 0", ChatFormats.GLOBAL.getPrefix().length() > 0);
    }
}
