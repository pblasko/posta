package hu.posta.szekesfehervar.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail() {
        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            String htmlContent = """
                <!DOCTYPE html>
                <html lang="hu">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Depó Statisztika</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            margin: 0;
                            padding: 0;
                        }
                        .card {
                            text-align: center;
                            font-size: 16px;
                            font-weight: bold;
                            padding: 10px;
                            margin: 5px 0;
                            border-radius: 5px;
                        }
                        .green-card {
                            background-color: #168a4a;
                            color: white;
                        }
                        .yellow-card {
                            background-color: #ffc409;
                            color: black;
                        }
                        .white-card {
                            background-color: #ffffff;
                            color: black;
                        }
                        .container {
                            width: 100%;
                            max-width: 600px;
                            margin: 0 auto;
                        }
                        table {
                            width: 100%;
                            border-collapse: collapse;
                        }
                        th, td {
                            padding: 10px;
                            border: 1px solid #ccc;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <div class="card green-card">A depó teljes gépjármű flottája: 50</div>
                        <table>
                            <tr>
                                <td class="card yellow-card">
                                    Szervízben: 5<br>
                                    <span style="font-size: 14px;">(+1 az előző héthez képest)</span>
                                </td>
                                <td class="card white-card">Itt jöhetne egy diagram (pl. kép formátumban).</td>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <td class="card green-card">Járatos: 20<br><span style="font-size: 14px;">(+2)</span></td>
                                <td class="card green-card">Csomagos: 10<br><span style="font-size: 14px;">(-1)</span></td>
                                <td class="card green-card">Hálózatos: 15<br><span style="font-size: 14px;">(+3)</span></td>
                                <td class="card green-card">Parkoló: 5<br><span style="font-size: 14px;">(0)</span></td>
                            </tr>
                        </table>
                        <div style="margin-top: 20px;">
                            <h4>Futó esetek:</h4>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Rendszám</th>
                                        <th>Típus</th>
                                        <th>Leírás</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>ABC-123</td>
                                        <td>Furgon</td>
                                        <td>Motorhiba - Javítás folyamatban</td>
                                    </tr>
                                    <tr>
                                        <td>XYZ-987</td>
                                        <td>Teherautó</td>
                                        <td>Olajcsere szükséges</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </body>
                </html>
                """;

            helper.setTo("blaskopeter@t-online.hu");
            helper.setSubject("Próba - Napi jelentés");
            helper.setText(htmlContent, true);

            helper.setFrom("blasko.peter.hu@gmail.com");

            mailSender.send(message);
        } catch (MessagingException e) {
            // Hiba kezelése
            System.err.println("Hiba történt az e-mail küldése során: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
