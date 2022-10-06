package entities;

public class Champion {
	
	private String name;
	private Integer life;
	private Integer attack;
	private Integer armor;
	
	public Champion() {
	}

	public Champion(String name, Integer life, Integer attack, Integer armor) {
		this.name = name;
		this.life = life;
		this.attack = attack;
		this.armor = armor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLife() {
		return life;
	}

	public void setLife(Integer life) {
		this.life = life;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getArmor() {
		return armor;
	}

	public void setArmor(Integer armor) {
		this.armor = armor;
	}
	
	public static void takeDamage(Champion championA, Champion championB) {
		int dead = 0;
		int danoA = 0;
		int resultadoA = 0;
		danoA = championA.getAttack() - championB.getArmor();
		if(danoA < 1) {
			danoA = 1;
		}
		resultadoA = championB.getLife() - danoA;
		if(resultadoA < 0) {
			championB.setLife(dead);
		} else {
			championB.setLife(resultadoA);
		}
		
		int danoB = 0;
		int resultadoB = 0;
		
		danoB = championB.getAttack() - championA.getArmor();
		if(danoB < 1) {
			danoB = 1;
		}
		resultadoB = championA.getLife() - danoB;
		if(resultadoB < 0) {
			championA.setLife(dead);
		} else {
			championA.setLife(resultadoB);
		}
	}
	
	public static String status(Champion championA, Champion championB) {
		takeDamage(championA, championB);
		if(championA.getLife() == 0) {
			return championA.getName() + 
					": " + 
					championA.getLife() + 
					" de vida (morreu)" + 
					"\n" + 
					championB.getName() + 					
					": " + championB.getLife() + 
					" de vida";
		} if(championB.getLife() == 0) {
			return championA.getName() + 
					": " + 
					championA.getLife() + 
					" de vida" + 
					"\n" + 
					championB.getName() + 					
					": " + championB.getLife() + 
					" de vida (morreu)";
			} else {
				return championA.getName() + 
						": " + 
						championA.getLife() + 
						" de vida" + 
						"\n" + 
						championB.getName() + 					
						": " + championB.getLife() + 
						" de vida";
				}
	}

}
