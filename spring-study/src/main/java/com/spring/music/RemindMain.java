package com.spring.music;

import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class RemindMain {
    //日志文件
    private static final String LOG_PATH = "D:\\develop\\code\\java\\RuoYi-Vue\\ruoyi-admin\\src\\main\\resources\\配置.ini";
    private static final String MUSIC_PATH = "D:\\develop\\code\\java\\java-frame-study\\spring-study\\src\\main\\resources\\world.mp3";
    private static final String TARGET_STRING = "StatusDesc";  // 替换为要捕捉的特定字符串

    public static void main(String[] args) {
        try {
            watchLogFile(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void watchLogFile(String[] args) throws IOException {
        Path logFile = Paths.get(LOG_PATH);

        // 检查文件是否存在
        if (!Files.exists(logFile)) {
            System.out.println("日志文件不存在：" + LOG_PATH);
            return;
        }

        // 使用WatchService监视文件变化
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            Path logDir = logFile.getParent();
            logDir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("开始监视日志文件：" + LOG_PATH);

            while (true) {
                WatchKey key;
                try {
                    key = watchService.take();  // 阻塞直到有文件变化事件发生
                } catch (InterruptedException e) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }

                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path modifiedFile = logDir.resolve(ev.context());

                    // 检查是否为目标日志文件
                    if (modifiedFile.equals(logFile)) {
                        processLogFile(logFile, args);
                    }
                }
                frameNotify();

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        }
    }

    private static void processLogFile(Path logFile, String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile.toFile()))) {
            String line;
            int i=0;
            while ((line = reader.readLine()) != null) {
                // 检查是否包含目标字符串
                if (line.contains(TARGET_STRING)) {
                    System.out.println("捕捉到特定字符串：" + TARGET_STRING);
//                    launch(args);

                    //发出声音
                    playSound(MUSIC_PATH);
                    ++i;
                    System.out.println(i);



                }
            }
        }
        //鸣叫后弹出提示框


    }

    private static void frameNotify() {
        JFrame frame = new JFrame("窗口标题");

        // 设置窗口大小和关闭操作
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // 让窗口居中显示

        // 显示窗口
        frame.setVisible(true);

        // 创建一个信息框
        JOptionPane.showMessageDialog(frame, "这是一个消息对话框！", "提示", JOptionPane.INFORMATION_MESSAGE);

        frame.setVisible(false);
    }


    private static void playSound(String filePath) {

/*        try{
        // 创建音频输入流
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));

            // 获取音频格式
            AudioFormat audioFormat = audioInputStream.getFormat();

            // 创建指定格式的音频格式
            AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    audioFormat.getSampleRate(),
                    16,
                    audioFormat.getChannels(),
                    audioFormat.getChannels() * 2,
                    audioFormat.getSampleRate(),
                    false);

            // 转换音频格式
            AudioInputStream convertedInputStream = AudioSystem.getAudioInputStream(targetFormat, audioInputStream);

            // 获取音频剪辑
        Clip clip = AudioSystem.getClip();

        // 打开音频剪辑并加载音频流
        clip.open(convertedInputStream);

        // 播放音频
        clip.start();

        // 等待音频播放完毕
        while (clip.isRunning()) {
            Thread.sleep(20000);
        }

        // 关闭音频剪辑和音频输入流
        clip.close();
        audioInputStream.close();
    } catch(UnsupportedAudioFileException |LineUnavailableException |IOException |
    InterruptedException e)

    {
        e.printStackTrace();
    }*/





        try (FileInputStream fis = new FileInputStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            Player player = new Player(bis);

            System.out.println("开始播放音频文件：" + filePath);


//            player.play();
            // 发出蜂鸣声
            for (int i = 0; i < 2; i++) {
                Toolkit.getDefaultToolkit().beep();

                Thread.sleep(1000);

            }


//            Toolkit.getDefaultToolkit().beep();
//
//            Toolkit.getDefaultToolkit().beep();


//                    Thread.sleep(20000);

//            JFrame frame = new JFrame("窗口标题");
//
//            // 设置窗口大小和关闭操作
//            frame.setSize(400, 300);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setLocationRelativeTo(null); // 让窗口居中显示
//
//            // 显示窗口
//            frame.setVisible(true);
//
//            // 创建一个信息框
//            JOptionPane.showMessageDialog(frame, "这是一个消息对话框！", "提示", JOptionPane.INFORMATION_MESSAGE);
//
//            frame.setVisible(false);

            System.out.println("音频播放完毕");

        } catch (IOException | javazoom.jl.decoder.JavaLayerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//            AudioInputStream ais = null;
//            try {
//                ais = AudioSystem.getAudioInputStream(new File(filePath));
//            } catch (UnsupportedAudioFileException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            AudioFormat format = ais.getFormat();
//
//            if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
//                format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(), 16,
//                        format.getChannels(), format.getChannels() * 2, format.getSampleRate(), false);
//                ais = AudioSystem.getAudioInputStream(format, ais);
//            }
//
//            String strCsvFileName = "test.csv";
//            File out = new File(strCsvFileName);
//            try {
//                out.createNewFile();
//
//            PrintWriter csvW = new PrintWriter(out);
//
//            byte[] buf = new byte[4];
//            while (ais.read(buf, 0, buf.length) >= 0) {
//
//                csvW.write(buf[1] + "," + buf[3] + "\n");
//            }
//            ais.close();
//            csvW.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }


//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        File audioFile = new File(MUSIC_PATH);
//        String audioFilePath = audioFile.toURI().toString();
//
//        Media media = new Media(audioFilePath);
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//
//        System.out.println("开始播放音频文件：" + MUSIC_PATH);
//
//        mediaPlayer.setAutoPlay(true);
//
//
//        Media media1 = mediaPlayer.getMedia();
//
//        mediaPlayer.play();
//
//        // 注册播放结束的监听器
//        mediaPlayer.setOnEndOfMedia(() -> {
//            System.out.println("音频播放完毕");
//            mediaPlayer.dispose();
//        });
//
//        // 关闭窗口时停止播放
//        primaryStage.setOnCloseRequest(event -> {
//            mediaPlayer.stop();
//            mediaPlayer.dispose();
//        });
//    }
//        private static void playSound() {
//     在此处添加播放声音的代码
//     可以使用Java Sound API或其他相关库来播放声音

//            try {
//     设置音频文件路径
//                String soundFi
        /*lePath = "D:\\develop\\code\\java\\RuoYi-Vue\\ruoyi-admin\\src\\main\\resources\\bird.wav"; // 替换为实际的音频文件路径

                // 创建音频输入流
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath));

                // 获取音频格式
                AudioFormat audioFormat = audioInputStream.getFormat();
                AudioFileFormat.Type[] audioFileTypes = AudioSystem.getAudioFileTypes();
                for (AudioFileFormat.Type audioFileType : audioFileTypes) {
                    System.out.println("系统支持的音频文件格式： "+audioFileType.getExtension()+"-------" +audioFileType.toString() );
                }
                // 创建数据行信息对象
                DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);

                // 检查系统是否支持数据行信息对象中指定的格式
                if (!AudioSystem.isLineSupported(info)) {
                    System.err.println("不支持该音频格式");
                    return;
                }

                // 获取音频数据行
                Clip clip = (Clip) AudioSystem.getLine(info);

                // 打开音频数据行
                clip.open(audioInputStream);

                // 播放声音
                clip.start();

                // 等待声音播放完毕
                Thread.sleep(clip.getMicrosecondLength() / 1000);

                // 关闭音频数据行和输入流
                clip.close();
                audioInputStream.close();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
*/

