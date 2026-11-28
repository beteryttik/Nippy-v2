package ru.nippy.gui;

import net.minecraft.client.input.MouseButtonEvent; // <-- Правильный импорт
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import ru.nippy.module.ModuleManager;
import ru.nippy.module.Module;
import ru.nippy.gui.ModuleCard;
import ru.nippy.gui.Theme;

import java.util.ArrayList;
import java.util.List;
// было: import net.minecraft.client.input.Click;
import net.minecraft.client.Click;

public class QuickMenuScreen extends Screen {
    private final List<ModuleCard> cards = new ArrayList<>();
    private int scrollY = 0;
    private static final int CARD_HEIGHT = 26;

    public QuickMenuScreen(TextRenderer textRenderer) {
        super(textRenderer);
        // Инициализируем карточки для всех модулей
        for (Module m : ModuleManager.getModules()) {
            cards.add(new ModuleCard(m));
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, width, height, Theme.BG);
        
        int totalHeight = cards.size() * CARD_HEIGHT;
        int offset = Math.max(0, totalHeight - height);
        
        for (int i = 0; i < cards.size(); i++) {
            ModuleCard card = cards.get(i);
            int y = i * CARD_HEIGHT + scrollY;
            
            // Не рисуем, если карточка ушла далеко за экран
            if (y + CARD_HEIGHT < 0 || y > height) continue;
            
            card.render(context, textRenderer, 10, y, width - 20);
        }
        
        // Рисуем скроллбар (упрощенно)
        context.drawStrokedRectangle(width - 15, 20, 10, height - 40, Theme.BORDER);
        int scrollHeight = Math.max(20, (height - 40) * (height - 40) / Math.max(1, totalHeight));
        int scrollPos = (int) ((float) scrollY / Math.max(1, totalHeight - height) * (height - 40 - scrollHeight));
        context.fill(width - 14, 20 + scrollPos, 8, scrollHeight, Theme.ACCENT);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        int totalHeight = cards.size() * CARD_HEIGHT;
        int maxScroll = Math.max(0, totalHeight - height);
        scrollY += amount;
        scrollY = Math.max(-maxScroll, Math.min(0, scrollY));
        return true;
    }

    // <-- ИСПРАВЛЕННАЯ СИГНАТУРА МЕТОДА
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // В Fabric/LibGui логика клика часто обрабатывается через MouseButtonEvent, 
        // но для простого экрана можно использовать базовую обработку или передать событие дальше.
        // Если твои карточки сами обрабатывают клики, этот метод можно оставить пустым или вызвать super.
        
        // Проходимся по карточкам в обратном порядке (на случай наложений)
        for (int i = cards.size() - 1; i >= 0; i--) {
            ModuleCard card = cards.get(i);
            int y = i * CARD_HEIGHT + scrollY;
            
            if (mouseX >= 10 && mouseX <= width - 10 && mouseY >= y && mouseY <= y + CARD_HEIGHT) {
                // Логика клика по карточке (переключение, раскрытие)
                // Здесь должна быть логика, которая есть у тебя в оригинале
                // Например: card.toggle(); или card.expand();
                // Для примера просто переключаем модуль:
                card.getModule().toggle();
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) { // Escape
            close();
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void close() {
        client.setScreen(null);
    }
}
