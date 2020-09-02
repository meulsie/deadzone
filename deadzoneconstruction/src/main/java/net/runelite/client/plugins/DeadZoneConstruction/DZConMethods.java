package net.runelite.client.plugins.DeadZoneConstruction;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public enum DZConMethods
{
	Larders("Oak Larders", 8778, '2', new int[]{15403}, new int[]{13566}, DZConPlugin.Type.GameObject),
	Dungeon_Doors("Oak Dungeon Doors", 8778, '1', new int[]{15326, 15327, 15328, 15329}, new int[]{13344, 13345}, DZConPlugin.Type.WallObject),
	Mahogany_Tables("Mahogany Tables", 8782, '6', new int[]{15298}, new int[]{13298}, DZConPlugin.Type.GameObject),
	Teak_Benches("Teak Benches", 8780, '1', new int[]{29136}, new int[]{29270}, DZConPlugin.Type.GameObject),
	Cape_Racks("Cape Racks", 8780, '4', new int[]{15394}, new int[]{31986}, DZConPlugin.Type.Decoration);

	private final String name;
	private final int requiredItem;
	private final char buildKey;
	private final int[] buildObjectIDs;
	private final int[] removeObjectIDs;
	private final DZConPlugin.Type type;

	DZConMethods(final String name, final int requiredItem, final char buildKey, final int[] buildObjectIDs, final int[] removeObjectIDs, final DZConPlugin.Type type)
	{
		this.name = name;
		this.requiredItem = requiredItem;
		this.buildKey = buildKey;
		this.buildObjectIDs = buildObjectIDs;
		this.removeObjectIDs = removeObjectIDs;
		this.type = type;
	}
}
