package net.runelite.client.plugins.DeadZoneConstruction;

import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.events.WidgetLoaded;

public interface DZConInterface
{
	void activate();

	void onGameTick();

	void onGameObjectSpawned(GameObjectSpawned gameObjectSpawned);

	void onWallObjectSpawned(WallObjectSpawned wallObjectSpawned);

	void onDecorativeObectSpawned(DecorativeObjectSpawned decorativeObjectSpawned);

	void onWidgetLoaded(WidgetLoaded widgetLoaded);

	void onAnimationedChanged(AnimationChanged animationChanged);
}
