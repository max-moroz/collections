package ua.com.foxminded.collections.context;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.collections.cache.Cache;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


class ContextTest {

    Context context = new Context();

    @Test
    void getObject_ShouldReturnObject_WhenInputClass() {
        Cache cache = new Cache();
        assertSame(cache.getClass(), context.getObject(Cache.class).getClass());
    }

    @Test
    void getObject_ShouldThrowException() throws Exception {
        Exception mockedException = mock(InstantiationException.class);
        Logger mockedLogger = mock(Logger.class);

        class Dummy {

            public Dummy() throws Exception {
                throw mockedException;
            }
        }

        try {
            Dummy dummy = context.getObject(Dummy.class);
        } catch (Exception e) {
            verify(mockedLogger, times(1)).log(Level.INFO, anyString());
        }
    }
}
