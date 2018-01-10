package pizza;

import java.util.HashMap;
import java.util.Map;

public class Pizza {
	
	public static double findPercent(Map<String, Map<String, Double>> h, String item, String ingredient)
	{
			double ans = 0;
			if(h.containsKey(item)){
				if(h.get(item).containsKey(ingredient)){
				ans += h.get(item).get(ingredient);
				}
				for (Map.Entry<String, Double> entry : h.get(item).entrySet()){
					ans += entry.getValue()*(findPercent(h, entry.getKey(), ingredient));
				}
			}
			return ans;
			
	}
	public static void main(String[] args){
		Map<String, Map<String, Double>> h = new HashMap<String, Map<String, Double>>();
		Map<String, Double> temp = new HashMap<String, Double>();
		temp.put("cheese",  0.4);
		temp.put("water", 0.2);
		h.put("pizza", temp);
		//temp.clear();
		Map<String, Double> temp1 = new HashMap<String, Double>();
		temp1.put("milk",0.6);
		temp1.put("water",0.3);
		h.put("cheese", temp1);
		Map<String, Double> temp3 = new HashMap<String, Double>();
		temp3.put("lactose", 0.5);
		
		temp3.put("water", 0.1);
		
		h.put("milk", temp3);
		
		System.out.println(findPercent(h,"pizza","water"));
		
	}

}
