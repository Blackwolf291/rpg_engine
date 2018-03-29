package nl.shadeblackwolf.engine.combat.matchers;

import org.hamcrest.Description;
import org.hamcrest.StringDescription;
import org.hamcrest.TypeSafeMatcher;

public abstract class SingleRunTypeSafeDiagnosingMatcher<T> extends TypeSafeMatcher<T> {
    private Description mismatchDescription;

    public boolean matchesType(Class clazz){
        return false;
    }

    @Override
    protected final boolean matchesSafely(T item) {
        mismatchDescription = new StringDescription();
        return matchesSafely(item, mismatchDescription);
    }

    protected abstract boolean matchesSafely(T item, Description mismatchDescription);

    @Override
    public final void describeMismatchSafely(T item, Description description) {
        description.appendText(mismatchDescription.toString());
    }
}