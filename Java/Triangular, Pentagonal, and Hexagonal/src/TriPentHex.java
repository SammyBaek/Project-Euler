public class TriPentHex {
	public static void main (String [] args){
				
		/**
		 * cross check all the numbers
		 */
		// Start at h=143, since the first matched is here
			/*
			 * Checked: h = (1, 22_000)
			 * Goal somewhere around (22_000, 30_000)
			 * 	ANS:1533776805
			 */
		first:
		for (long h = 22_000 ; h <= 30_000 ; h++){
			for (long p = h ; p <= 1_000_000 ; p++){
				if (p*(3*p-1)/2 > h*(2*h-1)){
					break;
				}
				if (p*(3*p-1)/2 == h*(2*h-1)){
					for (long t = p ; t <= 1_000_000 ; t++){
						System.out.println((h*(2*h-1)) + " " + (p*(3*p-1)/2) + " " + (t*(t+1)/2));
						if (t*(t+1)/2 == h*(2*h-1)){
							System.out.println("GOAL");
							break first;
						}
						if (t*(t+1)/2 > h*(2*h-1)){
							break;
						}
					}
				}
				System.out.println((h*(2*h-1)) + " " + (p*(3*p-1)/2));
			}
//				for (int h = 0; h <= 1000 ; h++){
//					// Since Integer class, gotta use .equals  :(
//					if (tri.get(t).equals(pent.get(p)) && tri.get(t).equals(hex.get(h))){
//						// Must verify SECOND matching number
//						if (!tri.get(t).equals(40755)){
//							System.out.println("GOAL");
//							System.out.println(tri.get(t));
//							break first;
//						}
//					}
//					if (hex.get(h) > tri.get(t)){
//						break;
//					}
//					if (pent.get(p) > tri.get(t)){
//						break second;
//					}
//					
//					System.out.println(tri.get(t) + " " + pent.get(p) + " " + hex.get(h));
//				}
//			}
		}

	}

}
