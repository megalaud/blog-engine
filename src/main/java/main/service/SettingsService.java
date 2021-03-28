package main.service;

import main.api.response.SettingsResponse;
import main.model.GlobalSetting;
import main.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class SettingsService
{
    @Autowired
    private SettingsRepository settingsRepository;

    public SettingsResponse getGlobalSettings()
    {
        GlobalSetting globalSetting1 = settingsRepository.getSettingsByCode("MULTIUSER_MODE");
        GlobalSetting globalSetting2 = settingsRepository.getSettingsByCode("POST_PREMODERATION");
        GlobalSetting globalSetting3 = settingsRepository.getSettingsByCode("STATISTICS_IS_PUBLIC");

        if(globalSetting1 == null)
        {
            globalSetting1 = new GlobalSetting("MULTIUSER_MODE","Многопользовательский режим","NO");
            settingsRepository.save(globalSetting1);
        }
        if(globalSetting2 == null)
        {
            globalSetting2 = new GlobalSetting("POST_PREMODERATION","Премодерация постов","NO");
            settingsRepository.save(globalSetting2);
        }
        if(globalSetting3 == null)
        {
            globalSetting3 = new GlobalSetting("STATISTICS_IS_PUBLIC","Показывать всем статистику блога","NO");
            settingsRepository.save(globalSetting3);
        }

        SettingsResponse settingsResponse = new SettingsResponse();
        settingsResponse.setMultiuserMode(globalSetting1.getValue().equals("YES"));
        settingsResponse.setPostPremoderation(globalSetting2.getValue().equals("YES"));
        settingsResponse.setStatisticIsPublic(globalSetting3.getValue().equals("YES"));

        return settingsResponse;
    }
}
