import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBus {
	public int aCount = 0;
	public int bCount = 0;
	private int teaBreakTime = 0;
	private List<BusPoint> collectionsA;
	private List<BusPoint> collectionsB;

	public TestBus() {
		super();
		this.collectionsA = new ArrayList<>();
		this.collectionsB = new ArrayList<>();
	}

	public static void main(String[] args) {

		TestBus tb = new TestBus();
		tb.collectionsA.add(new BusPoint(900, 1030));
		tb.collectionsA.add(new BusPoint(1200, 1345));

		Collections.sort(tb.collectionsA);

		Collections.sort(tb.collectionsB);

		tb.lookOutForBusCount(tb.teaBreakTime, tb.collectionsA, tb.collectionsB);

	}

	public int getTeaBreakTime() {
		return teaBreakTime;
	}

	public void setTeaBreakTime(int teaBreakTime) {
		this.teaBreakTime = teaBreakTime;
	}

	public List<BusPoint> getCollectionsA() {
		return collectionsA;
	}

	public void setCollectionsA(List<BusPoint> collectionsA) {
		this.collectionsA = collectionsA;
	}

	public List<BusPoint> getCollectionsB() {
		return collectionsB;
	}

	public void setCollectionsB(List<BusPoint> collectionsB) {
		this.collectionsB = collectionsB;
	}

	private void lookOutForBusCount(int teaTime, final List<BusPoint> collectionsA, final List<BusPoint> collectionsB) {
		if (collectionsA.isEmpty()) {
			this.aCount = 0;
			this.bCount = collectionsB.size();
			return;
		}
		if (collectionsB.isEmpty()) {
			this.aCount = collectionsA.size();
			this.bCount = 0;
			return;
		}
		if (collectionsA.get(0).startTime < collectionsB.get(0).startTime) {
			for (BusPoint bustPointA : collectionsA) {
				bustPointA.canUseSameBus(0, collectionsB);
			}
		}
		if (collectionsA.get(0).startTime > collectionsB.get(0).startTime) {
			for (BusPoint bustPointB : collectionsB) {
				bustPointB.canUseSameBus(0, collectionsA);
			}
		}
		this.aCount = this.printCollections(collectionsA);
		this.bCount = this.printCollections(collectionsB);

	}

	private int printCollections(final List<BusPoint> collectionsA) {
		int counter = 0;
		for (BusPoint bustPoint : collectionsA) {
			if (bustPoint.newBusRequired) {
				counter++;
			}
		}
		return counter;
	}
}

class BusPoint implements Comparable<BusPoint> {
	Integer startTime, endTime;
	boolean newBusRequired = true;

	public BusPoint(int start, int end) {
		this.startTime = start;
		this.endTime = end;
	}

	@Override
	public int compareTo(BusPoint o) {
		return this.startTime.compareTo(o.startTime);
	}

	public boolean canUseSameBus(int teaBreakTime, List<BusPoint> collectionsB) {
		// if ((this.startTime == (o.endTime + teaBreakTime))) {
		// return -1;
		// } else if ((this.startTime == (o.endTime + teaBreakTime))) {
		// return 1;
		// }
		for (BusPoint busPoint : collectionsB) {
			// if ((this.endTime > (busPoint.startTime + teaBreakTime))) {
			// return -1;
			// }

			if ((this.endTime == (busPoint.startTime + teaBreakTime))) {
				System.out.println(this + "B:" + busPoint);
				busPoint.newBusRequired = false;
				return true;// it's same and can use same bus for this route
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "BusPoint [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}