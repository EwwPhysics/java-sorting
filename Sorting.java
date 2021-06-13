import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.Math;
import java.util.*;

public class Sorting extends JPanel {
	private final int WIDTH = 900;
	private final int HEIGHT = 600;
	
	private int[] arr = new int[100];
	
	private boolean started;
	private int cur1;
	private int cur2;
	private int cur3;
	
	public Sorting() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		arr = new int[100];
		started = false;
		cur1 = 0;
		cur2 = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 350);
		}
	}
	
	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		paintImmediately(getVisibleRect());
	}

	public void bubbleSort() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				cur1 = j;
				cur2 = j + 1;
				if (arr[j] > arr[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}
	
	public void insertionSort() {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;
			while (i >= 0 && arr[i] > key) {
				cur1 = i + 1;
				cur2 = i;
				arr[i + 1] = arr[i];
				this.paintImmediately(getVisibleRect());
				i--;
			}
			arr[i + 1] = key;
		}
	}
	
	public void insertionSort(int l, int r) {
		for (int j = l; j < r; j++) {
			int key = arr[j];
			int i = j - 1;
			while (i >= l && arr[i] > key) {
				cur1 = i + 1;
				cur2 = i;
				arr[i + 1] = arr[i];
				this.paintImmediately(getVisibleRect());
				i--;
			}
			arr[i + 1] = key;
		}
	}
	
	public void mergeSort(int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(l, m);
			mergeSort(m + 1, r);
			merge(l, m, r);
		}
	}
	
	public void merge(int l, int m, int r) {
		int[] l_arr = Arrays.copyOfRange(arr, l, m + 1);
		int[] r_arr = Arrays.copyOfRange(arr, m + 1, r + 1);
		int i = 0;
		int j = 0;
		int index = l;
		
		while (i < l_arr.length && j < r_arr.length) {
			cur1 = index;
			if (l_arr[i] < r_arr[j]) {
				cur2 = i + l;
				this.paintImmediately(getVisibleRect());
				arr[index] = l_arr[i];
				i++;
			}
			else {
				cur2 = j + m + 1;
				this.paintImmediately(getVisibleRect());
				arr[index] = r_arr[j];
				j++;
			}
			index++;
		}
		
		while (i < l_arr.length) {
			cur1 = i + l;
			cur2 = index;
			this.paintImmediately(getVisibleRect());
			arr[index] = l_arr[i];
			i++;
			index++;
		}
		while (j < r_arr.length) {
			cur1 = j + m;
			cur2 = index;
			this.paintImmediately(getVisibleRect());
			arr[index] = r_arr[j];
			j++;
			index++;
		}
	}
	
	public void quickSort(int l, int r) {
		if (l < r) {
			if (r - l > 10) {
				int q = partition(l, r);
				quickSort(l, q - 1);
				quickSort(q + 1, r);
			} else {
				insertionSort(l, r + 1);
			}
		}
	}
	
	public int partition(int l, int r) {
		int x = arr[r];
		cur1 = r;
		int i = l - 1;
		for (int j = l; j < r; j++) {
			
			if (arr[j] <= x) {
				i++;
				swap(i, j);
				cur3 = i;
			}
			cur2 = j;
			try {
			    Thread.sleep(8);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		swap(i + 1, r);
		return i + 1;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
		
		g2.setColor(Color.WHITE);
		for (int i = 0; i < arr.length; i++) {
			if (cur1 == i || cur2 == i || cur3 == i) {
				g2.setColor(Color.MAGENTA);
			}
			g2.fillRect(i * WIDTH / arr.length, HEIGHT - arr[i], WIDTH / arr.length, arr[i]);
			g2.setColor(Color.WHITE);
		}
		if (!started) {
			started = !started;
			mergeSort(0, arr.length - 1);
		}
	}
}
