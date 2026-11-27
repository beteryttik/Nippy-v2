package ru.nippy.modules.world;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class BlockHighlighter extends Module {
    public BlockHighlighter() {
        super("BlockHighlighter", Category.WORLD, "Подсветка блока в прицеле");
        bool("Enabled", true); mode("Style", "Box", "Outline", "Fill"); slider("Opacity", 40, 0, 100);
    }

}
