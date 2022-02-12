/**
 * class computes [attempts to at least :( ] the shortest path to the destination of the map
 * @author jason
 * 
 */
public class ShortestPath {
	CityMap cityMap;
	/**
	 * initializes the map being used
	 * @param theMap variable holding the name of the map's text file
	 */
	public ShortestPath(CityMap theMap) {
		cityMap = theMap;
	}
	/**
	 * method computers the shortest path to the destination
	 */
	public void findShortestPath() {
		OrderedCircularArray<MapCell> list = new OrderedCircularArray<MapCell>();
		MapCell start = cityMap.getStart();
		list.insert(start, 0);
		start.markInList();
		boolean destfound = false;
		int distance = 0;
		while(!(list.isEmpty())&&(destfound==false)) {
			MapCell smallest = list.getSmallest();
			smallest.markOutList();
			if(nextCell(smallest).isDestination()) {
				destfound=true;
			}
			if(smallest.isDestination()) {
				destfound = true;
			}else{
				for(int i =0;i<3;i++) {
					MapCell curr =(nextCell(smallest));
					if(curr!=null) {
						distance = 1+smallest.getDistanceToStart();
						if(curr.getDistanceToStart()>distance) {
							curr.setDistanceToStart(distance);
							curr.setPredecessor(smallest);
						}
						int currdist = curr.getDistanceToStart();
						if((curr.isMarkedInList())&&(currdist<list.getValue(curr))){
							list.changeValue(curr, currdist);
						}
						else if(curr.isMarkedInList()==false) {
							list.insert(curr, currdist);
							curr.markInList();
						}
					}
				}
			}
		}
		if(destfound==true) {
			System.out.println("Path found! Distance: "+distance);
		}else {
			System.out.println("No path found!");
		}
	}
	/**
	 * returns the next best cell to compute the path
	 * @param cell current cell
	 * @return the best cell
	 */
	private MapCell nextCell(MapCell cell) {	
		if(cell.isStart() || cell.isIntersection()){
			int i2=0;
			try {//check if intersection/start is next to destination
				for(int i=0; i<3;i++){
					if(!(cell.getNeighbour(i) == null)) {
						if(i==0) {
							if(((cell.getNeighbour(0)).isDestination()||cell.getNeighbour(0).isNorthRoad()||cell.getNeighbour(0).isIntersection())&& (!cell.getNeighbour(0).isMarked()&&!(cell.getNeighbour(0).isBlock()))){
								return cell.getNeighbour(0);
							}
						}else if(i==1) {
							if(((cell.getNeighbour(1)).isDestination()||cell.getNeighbour(1).isEastRoad()||cell.getNeighbour(1).isIntersection())&& (!cell.getNeighbour(1).isMarked()&&(!cell.getNeighbour(1).isBlock())&&!(cell.getNeighbour(1)==null))){
								return cell.getNeighbour(1);
							}
						}else if(i==2) {
							if(((cell.getNeighbour(2)).isDestination()||cell.getNeighbour(2).isSouthRoad()||cell.getNeighbour(2).isIntersection())&& (!cell.getNeighbour(2).isMarked()&&!(cell.getNeighbour(2).isBlock()))){
								return cell.getNeighbour(2);
							}
						}else if(i==3) {
							if(((cell.getNeighbour(3)).isDestination()||cell.getNeighbour(3).isWestRoad()||cell.getNeighbour(3).isIntersection())&& (!cell.getNeighbour(3).isMarked()&&!(cell.getNeighbour(3).isBlock()))){
								return cell.getNeighbour(3);
							}
						}
						//if(!cell.getNeighbour(i).isBlock() && !cell.getNeighbour(i).isMarked()) {
						//						if((cell.getNeighbour(i)).isDestination() && !cell.getNeighbour(i).isMarked()&&!(cell.getNeighbour(i).isBlock())){
						//							return cell.getNeighbour(i);
						//		}
						i2=i;
					}
				}
			}catch(Exception e){
				for(int iC=i2+1; iC<4;iC++){
					if(!(cell.getNeighbour(iC)==(null))) {
						//						if(!cell.getNeighbour(iC).isBlock() && !cell.getNeighbour(iC).isMarked()) {
						if((!cell.getNeighbour(iC).isMarked()&& !cell.getNeighbour(iC).equals(null)&&!(cell.getNeighbour(iC).isBlock()))){
							return cell.getNeighbour(iC);
						}
					}
				}
			}
			//Check if Intersection/Start is next to intersection
			for(int i=0; i<4;i++){
				if(!(cell.getNeighbour(i)== null)) {
					if(!cell.getNeighbour(i).isBlock() && !cell.getNeighbour(i).isMarked()) {
						//if (cell.getNeighbour(i).isIntersection()&& !cell.getNeighbour(i).isMarked()&&!(cell.getNeighbour(i).isBlock())) {
						if((i==0&&cell.getNeighbour(0).isNorthRoad())||(i==1&&cell.getNeighbour(0).isIntersection())) {
							return cell.getNeighbour(0);
						}else if((i==1&&cell.getNeighbour(1).isEastRoad())||(i==1&&cell.getNeighbour(1).isIntersection())) {
							return cell.getNeighbour(1);
						}else if((i==2&&cell.getNeighbour(2).isSouthRoad())||(i==1&&cell.getNeighbour(2).isIntersection())) {
							return cell.getNeighbour(2);
						}else if((i==3&&cell.getNeighbour(3).isWestRoad())||(i==1&&cell.getNeighbour(3).isIntersection())){
							return cell.getNeighbour(3);
						}
						return cell.getNeighbour(i);
					}
				}
			}

			//Roads North[0], East[1], South[2], West[3]
		}else if(cell.isNorthRoad()){
			//			if(!cell.getNeighbour(0).isBlock()&&!cell.getNeighbour(0).isMarked()) {
			//				return cell.getNeighbour(0);
			//			}
			if(((cell.getNeighbour(0)).isDestination()||cell.getNeighbour(0).isIntersection()||cell.getNeighbour(0).isNorthRoad()) && !cell.getNeighbour(0).isMarked()&& !cell.getNeighbour(0).equals(null)&&!(cell.getNeighbour(0).isBlock())){
				return cell.getNeighbour(0);
			}
		}else if (cell.isEastRoad()) {
			if(((cell.getNeighbour(1)).isDestination()||cell.getNeighbour(1).isIntersection()||cell.getNeighbour(1).isEastRoad())&& !cell.getNeighbour(1).equals(null)&&!(cell.getNeighbour(1).isBlock())){
				return cell.getNeighbour(1);
			}
		}else if(cell.isSouthRoad()){
			if(((cell.getNeighbour(2)).isDestination()||cell.getNeighbour(2).isIntersection()||cell.getNeighbour(2).isSouthRoad())&& !cell.getNeighbour(2).isMarked()&& !cell.getNeighbour(2).equals(null)&&!(cell.getNeighbour(2).isBlock())){
				return cell.getNeighbour(2);
			}
		}else if(cell.isWestRoad()) {
			if(((cell.getNeighbour(3)).isDestination()||cell.getNeighbour(3).isIntersection()||cell.getNeighbour(3).isWestRoad())&& !cell.getNeighbour(3).isMarked()&& !cell.getNeighbour(3).equals(null)&&!(cell.getNeighbour(3).isBlock())){
				return cell.getNeighbour(3);
			}
		}
		return null;
	}
}
