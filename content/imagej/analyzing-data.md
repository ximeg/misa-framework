+++
title = "Analyzing data"
weight = 40
type="page"
creatordisplayname = "Ruman Gerst"
creatoremail = "ruman.gerst@leibniz-hki.de"
lastmodifierdisplayname = "Ruman Gerst"
lastmodifieremail = "ruman.gerst@leibniz-hki.de"
+++

<p >MISA++ applications require a specific
set of parameters and that the input data is organized in a certain
way. You can either setup those conditions manually (see the MISA++
application’s manual) or use the parameter editor tool that is
provided by the MISA++ ImageJ plugin.</p>
<p >See <a href="#_sxxdn0gw5wmq"><font color="#1155cc"><u>Current
application</u></font></a> to see how to open the tool.</p>
<h3 class="western"><a name="_pih6rh8vsid3"></a>Overview</h3>
<p ><img src="/img/imagej/userguide_html_7b4f8d83c3c72b43.png" name="image121.png"    border="0"/>
</p>
<p >The user interface is divided into
three sections:</p>
<ol>
	<li><p >A toolbar with global actions</p>
	<li><p >Available settings, categorized
	into different tabs</p>
	<li><p >Parameter validation results</p>
</ol>
<h2 class="western"><a name="_25m43wgu61ds"></a>Toolbar actions</h2>
<p >The toolbar contains actions that
affect multiple setting categories. Following actions are available:</p>
<p ><br/>

</p>
<table  cellpadding="7" cellspacing="0">
	<col />

	<col />

	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<b>Action</b></p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<b>Description</b></p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<img src="/img/imagej/userguide_html_25e7e7ae0ee09811.png" name="image72.png" class="inline-image" border="0"/>
Import
			parameters</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Imports a compatible parameter file. It will import:</p>
			<ul>
				<li><p >Samples
				(but not the data)</p>
				<li><p >Algorithm
				parameters</p>
				<li><p >Sample
				parameters</p>
				<li><p >Runtime parameters</p>
			</ul>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<img src="/img/imagej/userguide_html_b477416cd79efea5.png" name="image64.png" class="inline-image" border="0"/>
Import
			folder</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Imports a folder that contains input data and creates new samples
			if necessary. The selected folder must follow a specific
			structure:</p>
			<ul>
				<li><p >It must
				contains sub-folders that represent the samples</p>
				<li><p >The
				sample-folders are structured as seen in the “<i>Data</i>”
				category (see  <a href="#_qyot2s350mgf"><font color="#1155cc"><u>Adding
				data</u></font></a>)</p>
				<li><p >If the folder contains a
				<i>parameters.json</i> file, it will be loaded via the “<i>Import
				parameters</i>” action</p>
			</ul>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<img src="/img/imagej/userguide_html_4d6d742dee2c4ba6.png" name="image29.png" class="inline-image" border="0"/>
Check
			parameters</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Triggers a manual check of all parameters (see <a href="#_qyot2s350mgf"><font color="#1155cc"><u>Validating
			the current settings</u></font></a>)</p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<img src="/img/imagej/userguide_html_ff801f752ab61775.png" name="image62.png" class="inline-image" border="0"/>
Export</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Exports the current data and parameters into a ready-to-use
			package for other computers if the current settings are valid (see
			<a href="#_qyot2s350mgf"><font color="#1155cc"><u>Validating the
			current settings</u></font></a>).</p>
			<p ><br/>

			</p>
			<p >This will
			copy all the data into the selected folder. Please make sure that
			the file system has enough space.</p>
			<p ><br/>

			</p>
			<p >This will not copy the the MISA++
			application itself.</p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<img src="/img/imagej/userguide_html_63631d3be680189.png" name="image60.png" class="inline-image" border="0"/>
Run</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Executes the analysis on the current computer.</p>
			<p ><br/>

			</p>
			<p >When the data is successfully
			analyzed, you can directly analyze the results (see <a href="#_wuplvgsxnu5l"><font color="#1155cc"><u>Analyzing
			results</u></font></a>).</p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<img src="/img/imagej/userguide_html_ef081c2083a666e2.png" name="image41.png" class="inline-image" border="0"/>
Help</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Provides access to the parameter editor documentation and the
			documentation of the current MISA++ application (<img src="/img/imagej/userguide_html_36868a0d47746c46.png" class="inline-image" name="image126.png"    border="0"/>
<i>Module
			documentation</i>)</p>
		</td>
	</tr>
</table>
<p ><br/>

</p>
<h2 class="western"><a name="_n139u1bglaww"></a>Managing samples</h2>
<p ><img src="/img/imagej/userguide_html_cc29b7e53bd0a75e.gif" />
</p>
<p >To add samples, select the “Samples”
category and click the “Add samples” button. You can enter the
name of one samples or add multiple lines where each line correspond
to one sample.</p>
<p >Next to each sample, there are two
available actions:</p>
<p ><br/>

</p>
<table  cellpadding="7" cellspacing="0">
	<col />

	<col />

	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<b>Action</b></p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<b>Description</b></p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<img src="/img/imagej/userguide_html_60dcc39329925810.png" name="image11.png" class="inline-image" border="0"/>
Rename
			sample</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Allows you to rename the sample. If the name already exists or is
			empty, nothing will happen.</p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<img src="/img/imagej/userguide_html_5a1cd430de89e54f.png" name="image100.png" class="inline-image" border="0"/>
Remove
			sample</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Removes the sample</p>
		</td>
	</tr>
</table>
<p >
</p>
<h2 class="western"><a name="_mavfx6jjpckr"></a>Importing data</h2>
<p >MISA++ applications define which input
data is required and which data is generated as output. Input data
must be structured in a way expected by the application. The MISA++
ImageJ plugin provides a graphical user interface for importing data.
</p>
<p ><img src="/img/imagej/userguide_html_55ba576ae153d21c.png" name="image106.png"    border="0"/>
</p>
<p >The user interface is divided into
three sections:</p>
<ol>
	<li><p >The currently selected sample</p>
	<li><p >A tree to navigate the input and
	output data</p>
	<li><p >A list of input and output data</p>
</ol>
<p >To import data into a sample, select it
in the list of available samples. To refine the data list if there
are a lot of entries, use the tree and the “<i>Filter …</i>”
bar.</p>
<p ><br/>

</p>
<p >By default, the list will display input
and output data. While the output data is only shown for reference,
you are required to set input data via the user interface elements.</p>
<p >Each data entry always has the
following structure:</p>
<p ><img src="/img/imagej/userguide_html_9d6653dcfff93a37.png" name="image46.png"    border="0"/>
</p>
<p ><br/>

</p>
<p ><br/>

</p>
<table  cellpadding="7" cellspacing="0">
	<col />

	<col />

	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<b>Input data interface element</b></p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<b>Description</b></p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Data type</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			The type of the data.</p>
			<p ><br/>

			</p>
			<p ><b>Tip</b>: Hover your mouse over
			this element to show information about the data type</p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Name</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Name of the data. Also acts as internal location within the MISA++
			application.
			</p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Importer settings</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			User interface specific to the currently selected importer.</p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Current Importer</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			The importer that provides the data to the MISA++ application.</p>
		</td>
	</tr>
</table>
<p ><br/>

</p>
<h4><a name="_694zqz3sztxg"></a>Importers</h4>
<p >The ImageJ plugin is designed to be
extendable via other plugins. This is for example needed if the
MISA++ application defines data types outside of images and
developers want to include support for this data type. It is also
possible to integrate new types of image sources such as a link to an
online database.
</p>
<p >By design, users can select from
various importers that are responsible for providing all necessary
files to the MISA++ application. To change the current importer,
click the "Current importer" button and select it.</p>
<p ><br/>

</p>
<p >We included following importers by
default:</p>
<p ><br/>

</p>
<p ><br/>

</p>
<table  cellpadding="7" cellspacing="0">
	<col />

	<col />

	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<b>Importer</b></p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			<b>Description</b></p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Folder link</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Supports any data type (is always available) and allows you to
			select a folder that contains the data.</p>
			<p ><br/>

			</p>
			<p >Hover your mouse over the
			<img src="/img/imagej/userguide_html_dc7ada534948eb26.png" name="image65.png" class="inline-image" border="0"/>
button
			to see what kind of files are expected.</p>
		</td>
	</tr>
	<tr >
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			OME TIFF</p>
		</td>
		<td  style="border: 1.00pt solid #000000; padding: 0.18cm"><p >
			Only available if the data type is “OME TIFF”.</p>
			<p ><br/>

			</p>
			<p >Click the
			<img src="/img/imagej/userguide_html_b477416cd79efea5.png" name="image39.png" class="inline-image" border="0"/>

			button to show possible image sources. If there are images loaded
			in ImageJ, you can import an
			<img src="/img/imagej/userguide_html_ff434d5cde2d1747.png" name="image58.png" class="inline-image" border="0"/>
image
			directly from ImageJ.</p>
		</td>
	</tr>
</table>
<p ><br/>

</p>
<h2 class="western"><a name="_t3htshcuyb4t"></a>Sample and algorithm
parameters</h2>
<p >Depending on the MISA++ application
there are a wide variety of sample and algorithm parameters that can
be changed in the
<img src="/img/imagej/userguide_html_60dcc39329925810.png" name="image56.png" class="inline-image" border="0"/>
<i>Sample
parameters and </i>
<img src="/img/imagej/userguide_html_60dcc39329925810.png" name="image71.png" class="inline-image" border="0"/>
<i>Algorithm
parameters</i> categories.</p>
<p ><img src="/img/imagej/userguide_html_397520cc6e3ad7f8.png" name="image74.png"    border="0"/>
</p>
<p >The user interface is divided into
three sections:</p>
<ol>
	<li><p >Parameter tree</p>
	<li><p >View and filter options</p>
	<li><p >Parameters</p>
</ol>
<p ><br/>

</p>
<p >Depending on the MISA++ application,
there can be many nested parameters. To navigate them, use the
parameter tree. If you select an entry in the tree, the list of
parameters will only show the selected value and its children.</p>
<p >To make navigation easier, you can hide
sub-trees by deselecting
<img src="/img/imagej/userguide_html_def6d663c94b097e.png" name="image97.png" class="inline-image" border="0"/>
<i>Objects</i>
and filtering the list via the “<i>Filter …</i>” bar.</p>
<p >By default, the parameter list will
limit the list of shown parameters. To disable this feature, select
<img src="/img/imagej/userguide_html_d9d88a392bb54e14.png" name="image94.png" class="inline-image" border="0"/>
<i>Whole
tree</i>.</p>
<p ><br/>

</p>
<p >Use the parameter list to change the
parameters. Hover your mouse over the interface elements (such as the
parameter name) to show documentation if available.</p>
<p ><br/>

</p>
<p >The
<img src="/img/imagej/userguide_html_7e9251409421e5be.png" name="image84.png" class="inline-image" border="0"/>
<i>Sample
parameters</i> category has an additional user interface element at
the top of the parameter tree to select the current sample.</p>
<h2 class="western"><a name="_pteyx6fnqw49"></a>Runtime parameters</h2>
<p >Runtime-parameters provide
application-wide settings on the number of threads, how
quantification data is written and additional settings specific to
some data types.</p>
<p >The user interface is the same as for
sample and algorithm parameters (see <a href="#_t3htshcuyb4t"><font color="#1155cc"><u>Sample
and algorithm parameters</u></font></a>).</p>
<h2 class="western"><a name="_qyot2s350mgf"></a>Validating the
current settings</h2>
<p >Some actions such as running the MISA++
application require that all parameters are valid and all data is
imported. The ImageJ plugin notifies about issues in the current
settings via the status bar.</p>
<p >It will show “No errors found” if
the parameters are valid and the error message if an issue was found.
If there are multiple issues, click the error message to show a
window that lists all errors.</p>
