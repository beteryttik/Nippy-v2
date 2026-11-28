package ru.nippy.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import ru.nippy.module.ModuleManager;

import java.util.ArrayList;
import java.util.List;

public class QuickMenuScreen extends Screen {
    private final List<ModuleCard> cards = new ArrayList<>();
    private int scroll;

    public QuickMenuScreen() {
        super(Text.literal("Nippy"));
        ModuleManager.getModules().forEach(m -> cards.add(new ModuleCard(m)));
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        ctx.fill(0, 0, this.width, this.height, Theme.BG);

        int y = 12 - scroll;
        for (ModuleCard card : cards) {
            if (y + card.getLastHeight() > 0 && y < this.height) {
                card.render(ctx, this.textRenderer, 12, y, this.width - 24);
            }
            y += card.getLastHeight();
        }

        super.render(ctx, mouseX, mouseY, delta);
    }

    @Override
    public void tick() {
        super.tick();
    }
}
