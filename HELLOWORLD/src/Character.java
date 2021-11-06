public class Character
{
		private int level;
        private String _name;
        public Character()
        {
        	
        }
        public Character(String name)
        {
            this._name = name;
        }
        public Character(int level, String name)
        {
        	this(name);
        	this.level = level;
        }
        public int getLevel()
        {
        	return this.level;
        }
        public void setLevel(int level)
        {
        	if(level >= 0) this.level = level;
        	else System.out.print("Level must be > 0");
        }
}