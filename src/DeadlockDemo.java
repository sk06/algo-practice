
public class DeadlockDemo {

	static class Resource {
		
		String name;

		public Resource( String name) {
			this.name = name;
		}
		
		public String getName(Resource resource) {
			return this.name;
		}
		
		public synchronized void lockResource(Resource resource) {
			System.out.printf("%s is locked by %s \n", resource.getName(resource), this.name);
			resource.unlockResource(this);
			System.out.printf("%s is unlocked by %s \n", resource.getName(resource), this.name);
		}
		
		public synchronized void unlockResource(Resource resource) {
			System.out.printf("%s unlocked resource %s \n", this,name, resource.getName(resource));
		}
		
		
	}
	
	private static Resource r1 = new Resource("Resource1"); 
	private static Resource r2 = new Resource("Resource2"); 

	public static void main(String[] args) {
		
		new Thread( new Runnable(){
			public void run() {
				r1.lockResource(r2);
			}}).start();
		
		new Thread( new Runnable(){
			public void run() {
				r2.lockResource(r1);
			}}).start();
		
		
	}

}
