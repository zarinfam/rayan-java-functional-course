package apple;

/**
 * Created by saeed on 2/18/16.
 */
public class GreenAndHigher150ApplesPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return (apple.getColor().equals(MainApple.GREEN)
                && apple.getWeight() > 150);
    }
}
