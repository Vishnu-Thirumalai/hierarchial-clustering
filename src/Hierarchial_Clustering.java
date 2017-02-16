import java.util.ArrayList;
import java.util.Scanner;

import data.*;

public class Hierarchial_Clustering {

	public static void main(String []args)
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("How many points are there?");
		int i = scn.nextInt();		
		
		System.out.print("How many clusters are required?");
		int k = scn.nextInt();
		
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		
		System.out.println("Enter each point as x y, followed by 'Enter'.");
		for(; i>0; i--)
		{
			clusters.add(new Cluster(new Point(scn.nextInt(), scn.nextInt())));
			scn.nextLine();
		}
		
		scn.close();
		
		solve(clusters,k);
	}

	private static void solve(ArrayList<Cluster> clusters,int k) {
		
		Cluster a = null;
		Cluster b = null;
		double dist = 0;
		int round = 1;
		int orig = clusters.size();
		
		while(clusters.size() > 1)
		{
			if(orig-round < k)
				break;
			
			a = clusters.get(clusters.size()-1);
			b = clusters.get(clusters.size()-2);
			dist = a.distance(b.getCentroid());
			
			for(int i=0; i < clusters.size()-1; i++)
			{
				for(int j =i+1; j < clusters.size(); j++)
				{
					if(clusters.get(i).distance(clusters.get(j).getCentroid()) < dist)
					{
						a = clusters.get(i);
						b = clusters.get(j);
						dist = clusters.get(i).distance(clusters.get(j).getCentroid());
					}
				}
			}
			
			a.add(b);
			clusters.remove(b);
			
			System.out.println("Round "+ round++ +":");
			for(Cluster c: clusters)
			{
				System.out.println(c);
			}
			System.out.println("\n");
		}
		
	}
}
