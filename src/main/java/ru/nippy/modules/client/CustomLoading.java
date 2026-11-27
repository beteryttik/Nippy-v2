package ru.nippy.modules.client;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class CustomLoading extends Module {
    public CustomLoading() {
        super("CustomLoading", Category.CLIENT, "Кастомный экран загрузки");
        bool("Enabled", true); mode("Art", "Winter Girl", "Crystal");
    }

}
