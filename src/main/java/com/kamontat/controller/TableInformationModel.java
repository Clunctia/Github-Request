package com.kamontat.controller;

import com.kamontat.model.TableInformation;

import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since 1/31/2017 AD - 1:21 AM
 */
public class TableInformationModel<T> extends DefaultTableModel {
	public ArrayList<T> rawData = new ArrayList<>();
	
	public TableInformationModel(Vector columnNames) {
		super(columnNames, 0);
	}
	
	public TableInformationModel(TableInformation<T> info) {
		super(getVVString(info.getStringInformationVector()), info.getStringTitleVector());
		rawData.add(info.getRawData());
	}
	
	private static Vector<Vector<Object>> getVVString(Vector<Object> vs) {
		Vector<Vector<Object>> v = new Vector<>(1);
		v.add(vs);
		return v;
	}
	
	public void addRow(TableInformation<T> info) {
		if (!rawData.contains(info.getRawData())) {
			super.addRow(info.getStringInformationVector());
			rawData.add(info.getRawData());
		} else {
			PopupLog.getLog(null).warningMessage("Duplicate User", "This user already add to table");
		}
	}
	
	public void deleteRow(int row) {
		super.removeRow(row);
		rawData.remove(row);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
