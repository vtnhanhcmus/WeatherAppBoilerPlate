<%@ include file="common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3></h3>
		</div>
		<div class="panel-body">
			<table data-toggle="table">

				<tbody>
					<c:forEach items="${weathers}" var="w">
						<tr>

							<td>
								<img src="http://openweathermap.org/img/w/${w.icon}.png"/>
							</td>

							<td>
								<b>${w.city.name}</b>
								<br/>
								<b>${w.date}</b>
							</td>

							<td>
								<p>
									<span class="badge badge-info">${w.temperature} &#176;F</span>
									temperature from ${w.temperature} to ${w.temperature}&#176;F, wind
										${w.windSpeed} m/s. clouds ${w.clouds} %, 1014 hpa
								</p>

							</td>

							<td>
								<a href="#" onclick="'deleteWeather('+ ${w.id} + ');'">DELETE</a>

							</td>

						</tr>

					</c:forEach>


				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jsp"%>