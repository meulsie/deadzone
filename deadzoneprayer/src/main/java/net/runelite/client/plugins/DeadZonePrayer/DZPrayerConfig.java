package net.runelite.client.plugins.DeadZonePrayer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Title;

@SuppressWarnings("unused")
@ConfigGroup("DZPrayerConfig")
public interface DZPrayerConfig extends Config {
   @ConfigTitleSection(
      keyName = "prayerTitle",
      name = "Prayers Config",
      position = 0,
      description = ""
   )
   default Title prayerTitle() {
      return new Title();
   }

   @ConfigItem(
      keyName = "handlePrevPrayers",
      name = "Disable Previous Prayers",
      description = "Disable previous prayers when activating new prayers",
      position = 1,
      titleSection = "prayerTitle"
   )
   default boolean handlePrevPrayers() {
      return true;
   }

   @ConfigItem(
      keyName = "disableOnDeactivation",
      name = "Disable on Deactivation",
      description = "Disable prayer when deactivating the prayer flicker",
      position = 2,
      titleSection = "prayerTitle"
   )
   default boolean disableOnDeactivation() {
      return true;
   }

   @ConfigItem(
      keyName = "onlyInNMZ",
      name = "Only in NMZ",
      description = "Prayer flicker will only function while within NMZ",
      position = 3,
      titleSection = "prayerTitle"
   )
   default boolean onlyInNMZ() {
      return false;
   }

   @ConfigItem(
      keyName = "clearChat",
      name = "Clear Chat Key",
      description = "Automatically removes typed key from chat",
      position = 4,
      titleSection = "prayerTitle"
   )
   default boolean clearChat() {
      return true;
   }

   @ConfigTitleSection(
      keyName = "tglPrayersConfig",
      name = "Prayer Configuration",
      position = 1,
      description = ""
   )
   default Title tglPrayersConfig() {
      return new Title();
   }

   @ConfigItem(
      keyName = "prayerOneEnabled",
      name = "Prayer One Enabled",
      description = "Determines if the corresponding config is enabled",
      position = 4,
      titleSection = "tglPrayersConfig"
   )
   default boolean prayerOneEnabled() {
      return false;
   }

   @ConfigItem(
      keyName = "prayerItemsOne",
      name = "Prayer One Items",
      description = "Enter Prayer Names separated by a comma",
      position = 5,
      titleSection = "tglPrayersConfig"
   )
   default String prayerItemsOne() {
      return "";
   }

   @ConfigItem(
      keyName = "prayerTwoEnabled",
      name = "Prayer Two Enabled",
      description = "Determines if the corresponding config is enabled",
      position = 6,
      titleSection = "tglPrayersConfig"
   )
   default boolean prayerTwoEnabled() {
      return false;
   }

   @ConfigItem(
      keyName = "prayerItemsTwo",
      name = "Prayer Two Items",
      description = "Enter Prayer Names separated by a comma",
      position = 7,
      titleSection = "tglPrayersConfig"
   )
   default String prayerItemsTwo() {
      return "";
   }

   @ConfigItem(
      keyName = "prayerThreeEnabled",
      name = "Prayer Three Enabled",
      description = "Determines if the corresponding config is enabled",
      position = 8,
      titleSection = "tglPrayersConfig"
   )
   default boolean prayerThreeEnabled() {
      return false;
   }

   @ConfigItem(
      keyName = "prayerItemsThree",
      name = "Prayer Three Items",
      description = "Enter Prayer Names separated by a comma",
      position = 9,
      titleSection = "tglPrayersConfig"
   )
   default String prayerItemsThree() {
      return "";
   }

   @ConfigItem(
      keyName = "prayerFourEnabled",
      name = "Prayer Four Enabled",
      description = "Determines if the corresponding config is enabled",
      position = 10,
      titleSection = "tglPrayersConfig"
   )
   default boolean prayerFourEnabled() {
      return false;
   }

   @ConfigItem(
      keyName = "prayerItemsFour",
      name = "Prayer Four Items",
      description = "Enter Prayer Names separated by a comma",
      position = 11,
      titleSection = "tglPrayersConfig"
   )
   default String prayerItemsFour() {
      return "";
   }

   @ConfigItem(
      keyName = "prayerFiveEnabled",
      name = "Prayer Five Enabled",
      description = "Determines if the corresponding config is enabled",
      position = 12,
      titleSection = "tglPrayersConfig"
   )
   default boolean prayerFiveEnabled() {
      return false;
   }

   @ConfigItem(
      keyName = "prayerItemsFive",
      name = "Prayer Five Items",
      description = "Enter Prayer Names separated by a comma",
      position = 13,
      titleSection = "tglPrayersConfig"
   )
   default String prayerItemsFive() {
      return "";
   }

   @ConfigItem(
      keyName = "prayerSixEnabled",
      name = "Prayer Six Enabled",
      description = "Determines if the corresponding config is enabled",
      position = 14,
      titleSection = "tglPrayersConfig"
   )
   default boolean prayerSixEnabled() {
      return false;
   }

   @ConfigItem(
      keyName = "prayerItemsSix",
      name = "Prayer Six Items",
      description = "Enter Prayer Names separated by a comma",
      position = 15,
      titleSection = "tglPrayersConfig"
   )
   default String prayerItemsSix() {
      return "";
   }

   @ConfigTitleSection(
      keyName = "displayConfig",
      name = "Prayer Toggle Keys",
      position = 1,
      description = ""
   )
   default Title displayConfig() {
      return new Title();
   }

   @ConfigItem(
      keyName = "prayerFlickKey",
      name = "Prayer Flick",
      description = "Automatically 1 tick flicks quick prayers",
      position = 0,
      titleSection = "prayerTitle"
   )
   default Keybind prayerFlickKey() {
      return new Keybind(96, 0);
   }

   @ConfigItem(
      keyName = "togglePrayerOne",
      name = "Prayer Key One",
      description = "Toggles Prayers for config one",
      position = 1,
      titleSection = "displayConfig"
   )
   default Keybind togglePrayerOne() {
      return new Keybind(97, 0);
   }

   @ConfigItem(
      keyName = "togglePrayerTwo",
      name = "Prayer Key Two",
      description = "Toggles Prayers for config two",
      position = 2,
      titleSection = "displayConfig"
   )
   default Keybind togglePrayerTwo() {
      return new Keybind(98, 0);
   }

   @ConfigItem(
      keyName = "togglePrayerThree",
      name = "Prayer Key Three",
      description = "Toggles Prayers for config three",
      position = 3,
      titleSection = "displayConfig"
   )
   default Keybind togglePrayerThree() {
      return new Keybind(99, 0);
   }

   @ConfigItem(
      keyName = "togglePrayerFour",
      name = "Prayer Key Four",
      description = "Toggles Prayers for config four",
      position = 4,
      titleSection = "displayConfig"
   )
   default Keybind togglePrayerFour() {
      return new Keybind(100, 0);
   }

   @ConfigItem(
      keyName = "togglePrayerFive",
      name = "Prayer Key Five",
      description = "Toggles Prayers for config five",
      position = 5,
      titleSection = "displayConfig"
   )
   default Keybind togglePrayerFive() {
      return new Keybind(101, 0);
   }

   @ConfigItem(
      keyName = "togglePrayerSix",
      name = "Prayer Key Six",
      description = "Toggles Prayers for config six",
      position = 6,
      titleSection = "displayConfig"
   )
   default Keybind togglePrayerSix() {
      return new Keybind(102, 0);
   }
}
