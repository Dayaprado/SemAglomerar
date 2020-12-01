<%-- 
    Document   : report
    Created on : Nov 14, 2020, 12:44:13 AM
    Author     : dayprado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header_chart.jsp" />
    <body>
        <jsp:include page="cabecalho_admin.jsp" />
        <div class="container-2">
            <h3>Olá!, ${loja}</h3>
            <% Boolean admin = Boolean.parseBoolean(request.getAttribute("admin").toString()); %>
            <% if (admin) { %>
                <form  method="post" action="/SemAglomerar/relatorio">
                    <div class="form-group">
                        <label class="label">Reportar quantidade:
                            <input type="number" id="quantidade" name="quantidade" min="1" max="999">
                            <button>Reportar</button>
                        </label>
                    </div>
                </form>
            <% } %>
            <canvas id="report"></canvas>
        </div>
        <jsp:include page="footer-fixed.jsp" />
    </body>
    <script type="text/javascript">
        var ctx = document.getElementById('report');
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ${horarios},
                datasets: [{
                    data: ${quantidade},
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                title: {
                    display: true,
                    position: 'bottom',
                    text: 'Histórico de pessoa por período'
                },                
                legend: {
                    display: false
                },
                scales: {
                    xAxes: [{
                        gridLines: {
                            display:false
                        }
                    }],
                    yAxes: [{
                        gridLines: {
                            display:true
                        },
                        ticks: {
                            stepSize: 5,
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
        
        myChart.canvas.parentNode.style.height = '600px';
        myChart.canvas.parentNode.style.width = '400px';
    </script>
</html>
