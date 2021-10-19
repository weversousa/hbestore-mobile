Pasta manifest
    - Todas as Activities do projeto devem ser declaradas no AndroidManifest.xml
    - Apenas uma Activity deve ser configurada como principal (MAIN) e com o ícone do aplicativo (LAUCHER)
    - As outras Actvities podem ter outros tipos de filtros, mas inicialmente elas devem ser declaradas apenas com o nome
<activity android:name=".NomeActivity" />



Pasta java - MainActivity
Uma Activity representa uma tela do aplicativo
    – Controla o estado
    – Controla os eventos de tela
    – Cada tela do eu aplicativo terá uma Activity relacionada
    • Para cada Acitivity criada, é obrigatório implementar o método onCreate(bundle)
        – Este método é chamado automaticamente quando a tela é criada