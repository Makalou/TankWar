package components.physics;

public class hasDireRigidbody extends Rigidbody {
    protected Direction direction;
    public enum Direction{
        UP(0),DOWN(136),LEFT(204),RIGHT(68);
        public int value;
        private Direction(int value){
            this.value=value;
        }
    }
    public void setDirection(Direction direction){this.direction = direction;}
    public Direction getDirection(){return direction;}
}
