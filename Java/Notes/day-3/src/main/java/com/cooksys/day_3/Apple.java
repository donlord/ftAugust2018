package com.cooksys.day_3;

public class Apple {
	
	private String color;
	private String ripeness;
	
	public Apple(String color, String ripeness) {
		this.color = color;
		this.ripeness = ripeness;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRipeness() {
		return ripeness;
	}

	public void setRipeness(String ripeness) {
		this.ripeness = ripeness;
	}

	@Override
	public String toString() {
		return "Apple";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((ripeness == null) ? 0 : ripeness.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (ripeness == null) {
			if (other.ripeness != null)
				return false;
		} else if (!ripeness.equals(other.ripeness))
			return false;
		return true;
	}

}
