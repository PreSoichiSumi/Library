package classes;

import java.util.Arrays;

class Dijkstra{
	FastScanner sc=new FastScanner();
	private boolean[] decided;
	private long[][] dist;
	private final int N;
	int ai,bi,ti;
	int src;
	public long INF=Long.MAX_VALUE/2-1;
	public Dijkstra(int n) {
		N=n;
	}

	public void setGraph(long[][] graph){
		dist=graph.clone();
	}
	public void setPath(int start){
		src=start;
//		dest=goal;
	}

	public long[] getShortests(){
		decided=new boolean[N];
		Arrays.fill(decided, false);
		decided[src]=true;
		int minIndex=-1;
		long min;
		while(!isFinished(decided)){
			min=INF;
			for(int i=0;i<N;i++){//決まっていないところで最小の場所を探す
				if(!decided[i]&&dist[src][i]<min){
					min=dist[src][i];
					minIndex=i;
				}
			}
			//更新
			if(minIndex==-1){
				System.out.println("indexError");
			}else{
				decided[minIndex]=true;
				for(int j=0;j<N;j++){
					dist[src][j]=Math.min(dist[src][j],
							dist[src][minIndex]+dist[minIndex][j]);
				}
			}
		}
		long[] res=new long[N];
		for(int i=0;i<N;i++){
			res[i]=dist[src][i];
		}
		return res;
	}
	public static boolean isFinished(boolean[] array){
		boolean uncheckedElem=true;
		for(int i=0;i<array.length;i++){
			if(array[i]==false){
				uncheckedElem=false;
				break;
			}
		}
		return uncheckedElem;
	}
}